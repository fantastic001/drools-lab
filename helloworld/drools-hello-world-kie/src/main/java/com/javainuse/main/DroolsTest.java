package com.javainuse.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;

import com.javainuse.model.*;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			System.out.println("Starting application....");
			KieServices ks = KieServices.Factory.get();
			System.out.println("Getting classpath container....");
			KieContainer kContainer = ks.getKieClasspathContainer();
			System.out.println("Creating session....");
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			kSession.setGlobal("logger", new Logger());
			System.out.println("Creating product....");

			Product product = new Product();
			product.setType("pizza");
			product.setPrice(10);
			ArrayList<OrderedProduct> items = new ArrayList<OrderedProduct> ();
			OrderedProduct orderedProduct = new OrderedProduct(1, product);
			items.add(orderedProduct);
			Order order = new Order(items);

			FactHandle fact1;
			System.out.println("Inserting object into session");
			if (kSession == null) System.out.println("kSession is null!");
			fact1 = kSession.insert(orderedProduct);
			fact1 = kSession.insert(order);

			System.out.println("Firing rules");
			kSession.fireAllRules();


		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
