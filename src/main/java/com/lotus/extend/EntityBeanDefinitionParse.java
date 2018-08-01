package com.lotus.extend;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author Tony
 * 2018-07-31 14:24
 **/
public class EntityBeanDefinitionParse implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String id = element.getAttribute("id");
        String beanClassName = element.getAttribute("class");
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);

        BeanDefinitionReaderUtils.registerBeanDefinition(new BeanDefinitionHolder(beanDefinition, id),
                parserContext.getRegistry());

        return beanDefinition;
    }
}
