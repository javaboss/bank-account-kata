package org.acmebank.katas.bankaccount

object Money {
}

case class Money(amount: BigDecimal) {
  def +(money: Money): Money = {
    new Money(this.amount + money.amount)
  }

  def -(money: Money): Money = {
    new Money(this.amount - money.amount)
  }
}
