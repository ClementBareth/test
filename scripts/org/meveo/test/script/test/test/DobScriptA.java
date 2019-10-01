package org.meveo.test.script.test.test;
import org.meveo.service.script.Script;
import org.meveo.model.technicalservice.endpoint.EndpointVariables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DobScriptA extends Script {
    int age;
    Date dateOfBirth; 

    @Override
    public void execute(Map<String, Object> methodContext) {
        Calendar now = Calendar.getInstance();
        System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
            + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
        now.add(Calendar.YEAR, -1*age);
        dateOfBirth = now.getTime();
        methodContext.put("result", "The dob is : " + dateOfBirth );
        //Double maxBudget = (Double) methodContext.get(EndpointVariables.MAX_BUDGET);
        String unit = (String) methodContext.get(EndpointVariables.BUDGET_UNIT);
    }

    public void setAge(int age){
        this.age=age;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }
}