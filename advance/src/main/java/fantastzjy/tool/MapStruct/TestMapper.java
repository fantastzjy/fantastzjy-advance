package fantastzjy.tool.MapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {

	TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

	ABO convertADtoToBo(ADTO ADTO);

	CBO convertCDtoToBo(CDTO CDTO);
}