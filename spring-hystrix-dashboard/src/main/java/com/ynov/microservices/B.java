package com.ynov.microservices;

public final class B extends A {

	@Override
	public void foo() {
		super.foo();
		System.out.println("foo from B");
	}
}
