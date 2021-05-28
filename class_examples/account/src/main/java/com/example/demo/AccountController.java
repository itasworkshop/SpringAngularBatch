package com.example.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private static List<Account> accounts = Stream.of(new Account(101, "saving", new BigDecimal(1000.00)),
			new Account(102, "current", new BigDecimal(5000.00)), new Account(103, "saving", new BigDecimal(3000.00)))
			.collect(Collectors.toList());

	@RequestMapping(path = "/accounts", method = RequestMethod.GET)
	public @ResponseBody List<Account> getAllAccounts() {
		return accounts;
	}

	@RequestMapping(path = "/accounts/{accountId}", method = RequestMethod.GET)
	public @ResponseBody Account getAccount(@PathVariable String accountId) {

		Optional<Account> optionalAccount = accounts.stream()
				.filter(account -> Integer.parseInt(accountId) == account.getAccountId()).findFirst();

		return optionalAccount.isPresent() ? optionalAccount.get()
				: new Account(0, "Default Account", new BigDecimal(0.0));
	}

	@RequestMapping(path = "/accounts", method = RequestMethod.POST)
	public @ResponseBody List<Account> addAccount(@RequestBody Account account) {
		accounts.add(account);
		return accounts;

	}

	@RequestMapping(path = "/accounts/{accountId}", method = RequestMethod.DELETE)
	public @ResponseBody List<Account> deleteAccount(@PathVariable String accountId) {
		accounts.removeIf(account -> Integer.parseInt(accountId) == account.getAccountId());
		return accounts;
	}

	@RequestMapping(path = "/accounts", method = RequestMethod.PUT)
	public @ResponseBody List<Account> updateAccount(@PathVariable Account acc) {
		accounts.removeIf(account -> acc.getAccountId() == account.getAccountId());
		accounts.add(acc);
		return accounts;
	}
}
