package com.utils.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.utils.fixtures.Address;
import com.utils.fixtures.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTemplate implements TemplateLoader {

    private Object[] getFirstNames(){
        Faker faker= new Faker();
        List<String> list= new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(faker.name().firstName());
        }
        return list.toArray();
    }

    @Override
    public void load() {

        Address valid = Fixture.from(Address.class).gimme("valid");
        Fixture.of(Employee.class).addTemplate("valid",new Rule(){{
            add("id",random(Integer.class,range(100,1000)));
            add("fname",random("testingminibytes","amuthan","udemy"));
            add("isFTE",random(true,false));
            add("roles",uniqueRandom(Arrays.asList("tester"),Arrays.asList("manager")));
            add("address",random(new Address("some str","Chennai"),valid));
        }});

        Fixture.of(Employee.class).addTemplate("invalidid",new Rule(){{
            add("id",random(Integer.class,range(1,3)));
            add("fname",random(getFirstNames()));
            add("isFTE",random(true,false));
            add("roles",uniqueRandom(Arrays.asList("tester"),Arrays.asList("manager")));
            add("address",random(new Address("some str","Chennai")));
        }});

        Fixture.of(Employee.class).addTemplate("invalidfname").inherits("valid",new Rule(){{
            add("fname",random("testing-mini-bytes","amu-than","ud-emy"));
        }});



    }
}
