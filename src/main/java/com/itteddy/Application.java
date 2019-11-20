package com.itteddy;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.apache.camel.CamelContext;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.ImportResource;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.telegram.TelegramComponent;
import org.apache.camel.processor.aggregate.AbstractListAggregationStrategy;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.processor.aggregate.GroupedBodyAggregationStrategy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Named("teddy-castApp")
@ImportResource("camel-context.xml")
public class Application{

    @Inject
    @ContextName("teddy-cast")
    CamelContext context;

    @Produces
    @Named(value = "groupedBodyAggregationStrategy")
    AggregationStrategy groupedBodyAggregationStrategy(){
        return new GroupedBodyAggregationStrategy();
    }
}