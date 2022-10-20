package com.project.cofeebets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.Wallet;
import com.project.cofeebets.repositories.WalletRepository;


@Service
public class WalletService {

		public final WalletRepository walletRepo;
		
		public WalletService(WalletRepository walletRepo) {
			this.walletRepo = walletRepo; 
		}
		
		
		public Wallet getOne(Long id) {
			Optional<Wallet> potentialWallet = walletRepo.findById(id); 
			return potentialWallet.isPresent() ? potentialWallet.get() : null; 
		}
		
		
		public List<Wallet> getAll() {
			return (List<Wallet>) walletRepo.findAll();
		}
		
		public Wallet getWalletById(Long id) {
			Optional<Wallet> potentialWallet = walletRepo.findById(id);
			return potentialWallet.isPresent() ? potentialWallet.get() : null; 
		}
		
		public Wallet getWalletByUserId(Long id) {
			Optional<Wallet> potentialWallet = walletRepo.findByUserId(id);
			return potentialWallet.isPresent() ? potentialWallet.get() : null; 
		}
		
		
			

		public Wallet addWallet(Wallet wallet) {
			return walletRepo.save(wallet); 
		}
		
		public Wallet updateWallet(Wallet wallet) {
			return walletRepo.save(wallet); 
		}
		
		public void delete(Long id) {
			walletRepo.deleteById(id);	
		}
		
		public Wallet findWallet(Long id) {
			Optional<Wallet> potentialWallet = walletRepo.findById(id); 
			return potentialWallet.isPresent() ? potentialWallet.get() : null; 
		}


	}
