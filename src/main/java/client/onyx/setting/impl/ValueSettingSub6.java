/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */
package client.onyx.setting.impl;

import client.onyx.setting.ValueSetting;
import client.onyx.theme.Util4;
import client.onyx.theme.impl.Cls;
import client.onyx.theme.impl.Util2;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class ValueSettingSub6
extends ValueSetting<Integer> {
    private boolean bool;
    private boolean bool2 = true;
    private IntSupplier intSupplier = () -> Util4.getPrimaryOnPrimaryRecord().primary();
    private boolean bool3;
    private boolean bool4;

    public ValueSettingSub6 getValueSettingSub6() {
        ValueSettingSub6 valueSettingSub6 = this;
        valueSettingSub6.bool3 = true;
        valueSettingSub6.handleBool2(true);
        return valueSettingSub6;
    }

    @Override
    public ValueSettingSub6 getBooleanSetting(String string) {
        ValueSettingSub6 valueSettingSub6 = this;
        super.getBooleanSetting(string);
        return valueSettingSub6;
    }

    public boolean isEnabled14() {
        return this.bool2;
    }

    public ValueSettingSub6 getValueSettingSub65() {
        this.bool2 = false;
        this.bool4 = false;
        return this;
    }

    @Override
    public ValueSettingSub6 getSetting2(BooleanSupplier booleanSupplier) {
        ValueSettingSub6 valueSettingSub6 = this;
        super.getSetting2(booleanSupplier);
        return valueSettingSub6;
    }

    @Override
    public JsonElement getJsonElement() {
        JsonObject jsonObject;
        if (!this.bool2) {
            return new JsonPrimitive(this.getInt7());
        }
        JsonObject jsonObject2 = jsonObject = new JsonObject();
        jsonObject2.addProperty("value", this.getInt7());
        jsonObject2.addProperty("accent", this.bool4);
        return jsonObject2;
    }

    public int getInt8() {
        return this.lambda15() | 0xFF000000;
    }

    @Override
    public void run5() {
        ValueSettingSub6 valueSettingSub6 = this;
        super.run5();
        valueSettingSub6.handleBool2(valueSettingSub6.bool3);
    }

    public ValueSettingSub6(String string, int n) {
        super(string, n);
    }

    public int getInt6() {
        return (Integer)super.lambda15() | 0xFF000000;
    }

    public ValueSettingSub6 getModeSetting3(Consumer<Integer> consumer) {
        ValueSettingSub6 valueSettingSub6 = this;
        super.getModeSetting3(consumer);
        return valueSettingSub6;
    }

    public int getInt5() {
        return Util2.getIntForInt6(this.lambda15());
    }

    @Override
    public Integer lambda15() {
        int n;
        if (!this.bool4) {
            return (Integer)super.lambda15();
        }
        ValueSettingSub6 valueSettingSub6 = this;
        int n2 = n = valueSettingSub6.intSupplier.getAsInt();
        return valueSettingSub6.bool ? Util2.getIntForInt4(n2, Util2.getIntForInt6((Integer)super.lambda15())) : n2 | 0xFF000000;
    }

    public String getString9() {
        if (this.bool) {
            Object[] objectArray = new Object[1];
            Integer n = this.lambda15();
            objectArray[0] = n;
            return String.format("#%08X", objectArray);
        }
        Object[] objectArray = new Object[1];
        objectArray[0] = this.lambda15() & 0xFFFFFF;
        return String.format("#%06X", objectArray);
    }

    public ValueSettingSub6 getValueSettingSub64(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
        return this;
    }

    public float[] getFloatArray() {
        return Util2.getFloatArrayForInt(this.lambda15());
    }

    public void handleBool2(boolean bl) {
        if (!this.bool2) {
            return;
        }
        this.bool4 = bl;
    }

    @Override
    public void handleJsonElement(JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            ValueSettingSub6 valueSettingSub6 = this;
            valueSettingSub6.handleObject2(jsonElement.getAsInt());
            valueSettingSub6.handleBool2(false);
            return;
        }
        if (!jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonElement = jsonObject.get("value");
        JsonElement jsonElement2 = jsonObject.get("accent");
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            this.handleObject2(jsonElement.getAsInt());
        }
        if (jsonElement2 != null && jsonElement2.isJsonPrimitive() && jsonElement2.getAsJsonPrimitive().isBoolean()) {
            this.handleBool2(jsonElement2.getAsBoolean());
        }
    }

    public ValueSettingSub6 getValueSettingSub63(double d) {
        ValueSettingSub6 valueSettingSub6 = this;
        return valueSettingSub6.getValueSettingSub64(() -> {
            Cls cls = Cls.getClsForInt(valueSettingSub6.intSupplier.getAsInt());
            return cls.getCls2(Util2.getDoubleForDouble(cls.getDouble() + d)).getInt();
        });
    }

    public boolean isEnabled12() {
        return this.bool;
    }

    public void handleFloat(float f, float f2, float f3, int n) {
        this.handleObject2(Util2.getIntForFloat(f, f2, f3, n));
    }

    public <O> ValueSettingSub6 getModeSetting2(ValueSetting<O> valueSetting, Predicate<O> predicate) {
        ValueSettingSub6 valueSettingSub6 = this;
        super.getModeSetting2(valueSetting, predicate);
        return valueSettingSub6;
    }

    public ValueSettingSub6 getValueSettingSub62() {
        this.bool = true;
        return this;
    }

    public int getInt7() {
        return (Integer)super.lambda15();
    }

    public ValueSettingSub6 getModeSetting(ValueSetting<Boolean> valueSetting) {
        ValueSettingSub6 valueSettingSub6 = this;
        super.getModeSetting(valueSetting);
        return valueSettingSub6;
    }

    public boolean isEnabled13() {
        return this.bool4;
    }
}

