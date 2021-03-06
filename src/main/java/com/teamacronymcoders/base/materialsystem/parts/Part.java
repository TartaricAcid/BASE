package com.teamacronymcoders.base.materialsystem.parts;

import java.util.Locale;

import com.teamacronymcoders.base.materialsystem.parttype.PartType;
import com.teamacronymcoders.base.util.TextUtils;

public class Part {
    private String name;
    private String shortUnlocalizedName;
    private String unlocalizedName;
    private String oreDictName;
    private String ownerId;
    private PartType partType;

    Part(String name, String oreDict, PartType partType, String ownerId) {
        this.name = name;
        this.shortUnlocalizedName = TextUtils.toSnakeCase(name);
        this.ownerId = "base";
        if (ownerId != null) {
            this.ownerId = ownerId;
        }
        this.unlocalizedName = this.ownerId + ".part." + this.shortUnlocalizedName;
        if(oreDict == null) {
            oreDict = name.substring(0, 1).toLowerCase(Locale.US) + name.substring(1);
        }
        this.oreDictName = TextUtils.removeSpecialCharacters(oreDict);
        this.partType = partType;
    }

    public String getName() {
        return name;
    }

    public String getShortUnlocalizedName() {
        return shortUnlocalizedName;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public PartType getPartType() {
        return partType;
    }

    public String getPartTypeName() {
        return partType.getName();
    }

    public String getOreDictPrefix() {
        return this.oreDictName;
    }

    public String getOwnerId() {
        return this.ownerId;
    }
}
