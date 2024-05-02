package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.DoubleBuffer;
import java.util.SortedSet;

@RestController
@RequestMapping("/app/v1/calculator") //class level mapping
public class CalculatorController {
    @GetMapping("/add/{num33}") //method level mapping
    public Double add(@RequestParam("num11") Double num1, @RequestParam("num22") Double num2,
                      @PathVariable("num33") Double num3){
        return num1+num2+num3;

       // using two types of getting input Request Param and path variable
    }
    @GetMapping("/sub/{num11}/{num22}")
    public Double sub(@PathVariable("num11") Double num1, @PathVariable("num22") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1 - num2;
        }else {
            result = num2 - num1;
        }
        return result;
    }

    //another type to input variable
    /*@PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDto calculatorDto){
        Double result=null;
         result = calculatorDto.getNum1() * calculatorDto.getNum2() * calculatorDto.getNum3() * calculatorDto.getNum4();
     return result;
    } */
    //Going to use RESPONSE ENTITY
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDto calculatorDto){
        Double result=null;
        result = calculatorDto.getNum1() * calculatorDto.getNum2() * calculatorDto.getNum3() * calculatorDto.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
