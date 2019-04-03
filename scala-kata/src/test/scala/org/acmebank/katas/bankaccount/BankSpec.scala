package org.acmebank.katas.bankaccount

import org.scalatest._

class BankSpec extends FlatSpec {

  "With an account we" can "deposit an amount to increase the balance" in {
    val myAccount = Account(Money(100.0))
    myAccount.deposit(Money(2000.0))
    myAccount.deposit(Money(50.0))

    assert(myAccount.statement != null)
  }

  "With an account we" can "retrieve the balance" in {
    val myAccount = Account(Money(100.0))
    assert(myAccount.balance != null)

  }

}
