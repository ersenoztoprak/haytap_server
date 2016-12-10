package com.ersen.service;

import com.ersen.entity.Need;
import com.ersen.entity.dto.request.CreateNeedDTO;

public interface NeedService {

	Need create(CreateNeedDTO dto);

}
