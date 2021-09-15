package com.utils.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.utils.fixtures.Address;

public class AddressTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Address.class).addTemplate("valid",new Rule(){{
            add("street",random("some str","adbcd st"));
            add("city",random("Chennai","Bangalore"));
        }});
    }
}
