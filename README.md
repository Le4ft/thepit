# PitRedux
This is a PitRemake! Completly coded by me! 
If you wish to download it and run it on your own server your gonna need some other plugins as this won't run completly on its on. 
But hey at least you got the Source Code incase you want to make your own remake! (The bots are coded in a seperate Github check out my repo "Hunter"
although it is a work in progress and currently I've been trying to make it run completly off traits but citizens isn't the most dependable) 

To setup your going to need to download something called [BuildTools](https://www.spigotmc.org/wiki/buildtools/) aswell as JDK-8 or OpenJDK-8. The prefered 
IDE I would say is [InteliJ](https://www.jetbrains.com/idea/download/) The rest will be easy as you will only need to get from VCS and then BAM! To compile it
your going to need to use gradle for that.

"Pit Redux" uses alot of packets in its code although it is fairly well built (I say otherwise) there is still alot of sloppy code.
For example, in [**redux.java**](https://github.com/Awesome-Sauces/PitRedux/blob/master/src/main/java/com/alpha/redux/redux.java) you can see all the command's being register in a fairly inefficent way:
```java
 getCommand("enchantPant").setExecutor(commands);
 getCommand("activateBooster").setExecutor(commands);
 getCommand("purchaseDyes").setExecutor(commands);
 getCommand("show").setExecutor(commands);
 getCommand("repairs").setExecutor(commands);
 getCommand("hub").setExecutor(commands);
 getCommand("veloCheck").setExecutor(commands);
 getCommand("play").setExecutor(commands);
 getCommand("oof").setExecutor(commands);
 getCommand("mkBoard").setExecutor(commands);
 getCommand("makeMonersRankers").setExecutor(commands);
 getCommand("rBoard").setExecutor(commands);
 getCommand("spawn").setExecutor(commands);
 getCommand("spawn").setExecutor(commands);
 getCommand("all").setExecutor(commands);
 getCommand("feed").setExecutor(commands);
 getCommand("shop").setExecutor(commands);
 getCommand("kit").setExecutor(commands);
 getCommand("streak").setExecutor(commands);
 getCommand("balance").setExecutor(commands);
 getCommand("KillMessageToggle").setExecutor(commands);
 getCommand("prestige").setExecutor(commands);
 getCommand("prestiges").setExecutor(commands);
 getCommand("mega").setExecutor(commands);
 getCommand("gold").setExecutor(commands);
 getCommand("checkPants").setExecutor(commands);
 getCommand("well").setExecutor(commands);
 getCommand("getXp").setExecutor(commands);
 getCommand("pants").setExecutor(commands);
 getCommand("malding").setExecutor(commands);
```

I would really appreaciate if you guys could help out by fixing these little things as it helps me implement new things quicker and
push out better updates to the Better Pit server!

Well for these commands I would probally make a class like this:

```java
public class ReduxCommandHandler{
  public ReduxCommandHandler(){
     getCommand("enchantPant").setExecutor(commands);
     getCommand("activateBooster").setExecutor(commands);
     getCommand("purchaseDyes").setExecutor(commands);
     getCommand("show").setExecutor(commands);
     getCommand("repairs").setExecutor(commands);
     getCommand("hub").setExecutor(commands);
     getCommand("veloCheck").setExecutor(commands);
     getCommand("play").setExecutor(commands);
     getCommand("oof").setExecutor(commands);
     getCommand("mkBoard").setExecutor(commands);
     getCommand("makeMonersRankers").setExecutor(commands);
     getCommand("rBoard").setExecutor(commands);
     getCommand("spawn").setExecutor(commands);
     getCommand("spawn").setExecutor(commands);
     getCommand("all").setExecutor(commands);
     getCommand("feed").setExecutor(commands);
     getCommand("shop").setExecutor(commands);
     getCommand("kit").setExecutor(commands);
     getCommand("streak").setExecutor(commands);
     getCommand("balance").setExecutor(commands);
     getCommand("KillMessageToggle").setExecutor(commands);
     getCommand("prestige").setExecutor(commands);
     getCommand("prestiges").setExecutor(commands);
     getCommand("mega").setExecutor(commands);
     getCommand("gold").setExecutor(commands);
     getCommand("checkPants").setExecutor(commands);
     getCommand("well").setExecutor(commands);
     getCommand("getXp").setExecutor(commands);
     getCommand("pants").setExecutor(commands);
     getCommand("malding").setExecutor(commands);
  }
}  
