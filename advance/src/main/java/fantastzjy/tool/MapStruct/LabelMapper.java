package fantastzjy.tool.MapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabelMapper {

	LabelMapper INSTANCE = Mappers.getMapper(LabelMapper.class);

	LabelBO convertDtoToBo(LabelDTO labelDTO);
}