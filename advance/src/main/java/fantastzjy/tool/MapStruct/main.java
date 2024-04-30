package fantastzjy.tool.MapStruct;

public class main {

	// 总结:https://juejin.cn/post/7333458486435987494
	public static void main(String[] args) {
		LabelDTO labelDTO = new LabelDTO();
		labelDTO.setLabelName("labelName");
		LabelBO labelBO = LabelMapper.INSTANCE.convertDtoToBo(labelDTO);
		System.out.println(labelBO.getLabelName());
	}
}
