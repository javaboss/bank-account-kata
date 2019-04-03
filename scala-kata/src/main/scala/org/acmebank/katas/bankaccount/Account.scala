package org.acmebank.katas.bankaccount

import java.time.LocalDateTime

import scala.collection.mutable.ListBuffer

object Account {
}

case class Account(amount: Money) {
  class Transaction(val amount: Money, val balance: Money) {
    val date: LocalDateTime = LocalDateTime.now()
  }

  val transactions = new ListBuffer[Transaction] += new Transaction(amount, amount)

  def deposit(amount: Money): Unit = {
    transactions += new Transaction(amount, transactions.last.amount + amount)
  }

  def withdraw(amount: Money): Unit = {
    transactions += new Transaction(Money(0.0) - amount, transactions.last.amount - amount)
  }

  def transfer(toAccount: Account, amount: Money): Unit = {
    toAccount.deposit(amount)
  }

  def balance: Money = {
    transactions.last.balance
  }

  def statement: String = {
    val statement: StringBuilder = new StringBuilder

    for (transaction <- transactions) {
      statement.append(s"Date: ${transaction.date} Amount: ${transaction.amount} Balance: ${transaction.balance}\n")
    }

    statement.toString
  }
}
