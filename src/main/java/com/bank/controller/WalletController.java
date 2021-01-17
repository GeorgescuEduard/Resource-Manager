package com.bank.controller;

import com.bank.dto.WalletDTO;
import com.bank.models.User;
import com.bank.models.Wallet;
import com.bank.service.UserService;
import com.bank.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WalletController {

    private final Logger logger = LoggerFactory.getLogger(WalletController.class);
    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/wallets", method = RequestMethod.GET)
    public String getWallets(Model model) {
        List<Wallet> walletList = walletService.findAllWallets();
        model.addAttribute("wallets", walletList);
        return "wallets";
    }

    @RequestMapping(value = "/wallet/add", method = RequestMethod.GET)
    public String getAddWalletForm(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        WalletDTO wallet = new WalletDTO();
        model.addAttribute("wallet", wallet);
        return "add-wallet";
    }

    @RequestMapping(value = "/wallet/add", method = RequestMethod.POST)
    public String addWalletForm(@Valid @ModelAttribute("wallet") WalletDTO walletDTO, BindingResult result, Model model,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            logger.error("Add wallet error: " + result.getAllErrors());
            List<User> userList = userService.findAllUsers();
            model.addAttribute("users", userList);
            return "add-wallet";
        } else {
            Wallet wallet = new Wallet();
            wallet.setWalletid(walletDTO.getWalletid());
            wallet.setName(walletDTO.getName());
            wallet.setDescription(walletDTO.getDescription());
            wallet.setAmount(walletDTO.getAmount());
            wallet.setUser(new User(walletDTO.getUserId()));
            walletService.add(wallet);
            redirectAttributes.addFlashAttribute("message", "A new wallet has been successfully added.");
            return "redirect:/wallets";
        }
    }

    @RequestMapping(value = "/wallet/update", method = RequestMethod.GET)
    public String getEditWalletForm(@RequestParam(value = "walletid", required = true) Long walletid, Model model,
                                    RedirectAttributes redirectAttributes) {
        Wallet wallet = walletService.findWallet(walletid);
        logger.debug("Edit wallet {}", wallet);
        if(wallet != null){
            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setWalletid(wallet.getWalletid());
            walletDTO.setName(wallet.getName());
            walletDTO.setDescription(wallet.getDescription());
            walletDTO.setAmount(wallet.getAmount());
            walletDTO.setUserId(wallet.getUser().getUserid());

            model.addAttribute("wallet", walletDTO);

            List<User> users = userService.findAllUsers();
            model.addAttribute("users", users);

            return "update-wallet";
        }else{
            logger.error("Edit error: Task with id {} not found", walletid);
            redirectAttributes.addFlashAttribute("errorMessage", "Task with specified id not found");
            return "redirect:/wallets";
        }
    }

    @RequestMapping(value = "/wallet/update", method = RequestMethod.POST)
    public String updateWallet(@Valid @ModelAttribute("wallet") WalletDTO walletDTO, BindingResult result, Model model,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            logger.error("Update task validation error: ", result.getAllErrors());
            List<User> userList = userService.findAllUsers();
            model.addAttribute("users", userList);
            return "update-wallet";
        } else{
            Wallet wallet = new Wallet();
            wallet.setWalletid(walletDTO.getWalletid());
            wallet.setName(walletDTO.getName());
            wallet.setDescription(walletDTO.getDescription());
            wallet.setAmount(walletDTO.getAmount());
            wallet.setUser(new User(walletDTO.getUserId()));
            walletService.update(wallet);

            return "redirect:/wallets";
        }
    }

    @RequestMapping(value = "/wallet/delete", method = RequestMethod.GET)
    public String deleteWallet(@Valid @ModelAttribute("walletid") Long walletid, BindingResult result,
                               RedirectAttributes redirectAttributes){
        try{
            walletService.delete(walletid);
            redirectAttributes.addFlashAttribute("message", "Wallet successfully deleted");
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Delete error: " + e.getMessage());
        }
        return "redirect:/wallets";
    }
}
