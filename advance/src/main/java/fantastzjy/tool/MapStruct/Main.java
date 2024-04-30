package fantastzjy.tool.MapStruct;

import org.springframework.beans.BeanUtils;

public class Main {

	/**
	 * 测试类型自动转换效果
	 * 总结:https://juejin.cn/post/7333458486435987494
	 * 拷贝效果,耗时对比/总结
	 */

	public static void main(String[] args) {

		// ************************** 1 使用 MapStruct **************************
		// 基本原理:使用预编译,在编译阶段自动生成Mapper接口实现类,查看实现类可知,会进行类型转换,且为空值时不会进行默认赋值,也可指定为空时的转换规则,如下:
		// @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)     ：当源值为null时，返回null。这是默认行为。
		// @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)  ：当源值为null时，返回目标类型的默认实例。这对于避免在目标对象中得到null值特别有用。

		//  Integer->int 若原值为空,则默认值0
		//  int->Integer 若原值为空,则新值为0

		ADTO adto = new ADTO();
		// adto.setCount(11111);
		ABO abo = TestMapper.INSTANCE.convertADtoToBo(adto);
		System.out.println(abo.getCount());

		// 2 String->int
		CDTO cdto = new CDTO();
		cdto.setCount("22222");
		CBO cbo = TestMapper.INSTANCE.convertCDtoToBo(cdto);
		System.out.println(cbo.getCount());

		// ************************** 1 使用 BeanUtils **************************
		// 1 属性类型不一致导致拷贝失败            A类中定义的类型为Long，在B类中定义的类型为String，会出现拷贝失败，导致对应的字段为null
		// 2 同一字段分别使用包装类型和基本类型     在没有传递实际值的时候，会出现异常,ps若传递实际值会成功
		//   注意，如果一个布尔类型的属性分别使用了基本类型和包装类型，且属性名如果使用is开头，例如isSuccess，也会导致拷贝失败
		// 3 null值覆盖导致数据异常              被拷贝的数据里面如果某些字段有null值存在，但是对应的需要被拷贝过去的数据的相同字段的值并不为null，会出现被拷贝数据的null值覆盖拷贝目标数据的字段，导致原有的数据失效
		// 4 底层实现为反射拷贝效率低
		// 5 导包错误导致拷贝数据异常


		// 若类型不一致,则转换结果为null,不会自动转化

		BDTO bdto = new BDTO();
		// bdto.setCount(33333);

		BBO bbo = new BBO();
		BeanUtils.copyProperties(bdto, bbo);
		System.out.println(bbo.getCount());
	}

	/**
	 * 在使用MapStruct进行对象映射时，`NullValueMappingStrategy`是一个重要的配置选项，它允许开发者指定当源字段为`null`时映射行为应如何处理。
	 * 主要有两种策略：`RETURN_NULL`和`RETURN_DEFAULT`，它们在处理`null`值时表现不同。
	 *
	 * ### 1 NullValueMappingStrategy.RETURN_NULL
	 *
	 * 当使用`RETURN_NULL`策略时，如果源对象为`null`，则MapStruct会将目标对象也映射为`null`。
	 * 这意味着，在映射过程中，如果任何源字段为`null`，相应的目标字段也会被设置为`null`（对于引用类型字段）或基本类型的默认值（例如，`int`为`0`，`boolean`为`false`等）。
	 * 这种策略适用于当你希望在映射结果中明确标识`null`值时的场景。它保证了`null`源值会直接映射为`null`目标值（或基本类型的默认值），不会尝试创建目标类型的任何默认实例。
	 *
	 * ### 2 NullValueMappingStrategy.RETURN_DEFAULT
	 *
	 * 而当使用`RETURN_DEFAULT`策略时，如果源对象为`null`，MapStruct会为目标对象创建一个默认实例，而不是返回`null`。
	 * 这意味着，如果源字段为`null`，MapStruct不仅不会将目标字段设置为`null`，而且会尝试使用目标字段类型的默认构造函数来创建一个新实例，并将其赋给目标字段。
	 * 这种策略特别适用于你希望避免在目标对象中出现`null`值的场景。
	 * 例如，这可以确保目标对象的集合字段永远不为`null`，而是至少是一个空集合，从而减少了在使用目标对象时需要进行`null`检查的场合。
	 *
	 * ### 3 示例
	 * 假设我们有如下的源类和目标类：
	 * public class Source {
	 *     private String value;
	 *     // getters and setters
	 * }
	 *
	 * public class Target {
	 *     private String value;
	 *     // getters and setters
	 * }
	 *
	 * 以及一个映射接口：
	 * @Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
	 * public interface MyMapper {
	 *     Target sourceToTarget(Source source);
	 * }
	 *
	 * 在这个例子中，如果`source`为`null`，那么使用`RETURN_NULL`策略的`sourceToTarget`方法也会返回`null`。
	 * 如果我们将`nullValueMappingStrategy`改为`RETURN_DEFAULT`，那么当`source`为`null`时，`sourceToTarget`方法会返回一个新的`Target`实例，其`value`字段为`null`（或基本类型字段为其对应的默认值）。
	 *
	 * 总的来说，选择哪种策略取决于你的具体需求，以及你如何希望在映射过程中处理`null`值。
	 */

	/**
	 * 注意坑点：
	 *  1 Mapper-struct同样也是浅拷贝，需要进行深拷贝，就写多个Converter把需要深拷贝的再转一次
	 *
	 * 2 跟lombok在配合的时候会出现问题，如果mapperStruct的依赖放在lombok的依赖上面的话就会出现在对象复制的时候，会将原有数据全变为null的情况.
	 * 所以一定要将lombok的依赖放在mapperStruct上面
	 */
}
