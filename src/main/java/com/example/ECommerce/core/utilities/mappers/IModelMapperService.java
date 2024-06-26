package com.example.ECommerce.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
}
