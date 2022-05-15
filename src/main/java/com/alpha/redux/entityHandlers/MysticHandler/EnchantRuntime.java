package com.alpha.redux.entityHandlers.MysticHandler;

import com.alpha.redux.entityHandlers.ReduxPlayer;
import com.alpha.redux.eventManagers.ReduxDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class EnchantRuntime {

    ReduxPlayer attacker;

    List<String> mysticPants = new ArrayList<>();
    List<String> mysticSword = new ArrayList<>();
    double eventDamage = 1;

    public EnchantRuntime(ReduxPlayer attacker, ReduxPlayer defender, double eventDamage){
        this.attacker = attacker;
        if(this.attacker.getPantEnchants() != null) mysticPants = attacker.getPantEnchants();
        if(this.attacker.getSwordEnchants() != null) mysticSword = attacker.getSwordEnchants();
        this.eventDamage = eventDamage;
    }

    public boolean calculateDamage(ReduxDamageEvent event){





        return false;
    }

}
