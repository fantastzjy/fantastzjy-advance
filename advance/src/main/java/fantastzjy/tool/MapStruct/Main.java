package fantastzjy.tool.MapStruct;

import org.springframework.beans.BeanUtils;

public class Main {

	/**
	 * 测试类型自动转换效果
	 * 总结:https://juejin.cn/post/7333458486435987494
	 */

	public static void main(String[] args) {

		// ************************** 1 使用 MapStruct **************************

		//  Integer->int 若原值为空,则默认值0
		//  int->Integer 若原值为空,则新值为0

		ADTO adto = new ADTO();
		// adto.setCount(11111);
		ABO abo = TestMapper.INSTANCE.convertDtoToBo(adto);
		System.out.println(abo.getCount());

		// 2 String->int
		CDTO cdto = new CDTO();
		cdto.setCount("22222");
		CBO cbo = TestMapper.INSTANCE.convertPersonDtoToBo(cdto);
		System.out.println(cbo.getCount());

		// ************************** 1 使用 BeanUtils **************************
		// 若类型不一致,则转换结果为null,不会自动转化

		BDTO bdto = new BDTO();
		// bdto.setCount("33333");

		BBO bbo = new BBO();

		BeanUtils.copyProperties(bdto, bbo);

		System.out.println(bbo.getCount());
	}
}
