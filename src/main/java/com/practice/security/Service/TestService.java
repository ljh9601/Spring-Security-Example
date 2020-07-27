package com.practice.security.Service;

import java.util.List;
import com.practice.security.Dto.TestDto;
import com.practice.security.Mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;
    
    public List<TestDto> getAll() throws Exception{
        return testMapper.getAll();
    }
}