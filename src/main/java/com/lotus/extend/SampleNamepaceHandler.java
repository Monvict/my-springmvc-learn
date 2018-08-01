package com.lotus.extend;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Tony
 * 2018-07-31 14:23
 **/
public class SampleNamepaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("entity", new EntityBeanDefinitionParse());
    }
}
