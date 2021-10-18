------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:


Scraps:


if (hClass == 'w')
        {
            hero = new Warrior(hName);
        }
        else if (hClass == 'm')
        {
            hero = new Mage(hName);
        }
        else if (hClass == 'r')
        {
            hero = new Rogue(hName);
        }
        hero.setHP(hHealth);
        if (hWeapon.equals("Zweihander"))
        {
            hero.setEquipped(new Weapon_Zweihander());
        }
        else if(hWeapon.equals("Knife"))
        {
            hero.setEquipped(new Weapon_Knife());
        }
        ui.hpLabel.setText(hero.getName()+" HP: ");
        ui.hpLabelNumber.setText(""+ hero.getHP());
        
        ui.weaponLabelName.setText(hero.getEquipped().getWeaponName());