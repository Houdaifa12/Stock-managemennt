package com.houdaifa.stockmanagement.validators;

import com.houdaifa.stockmanagement.Dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
private List<String>errors;
public List<String>validate(CommandeClientDto commandeClientDto){
  if(!StringUtils.hasLength(commandeClientDto.getCode())){
      errors.add("please enter the code of the command");
  }
  return errors;

}
}
