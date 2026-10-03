package client.onyx.gui.component;

import client.onyx.gui.Util2;
import client.onyx.input.CodepointModifiersRecord;
import client.onyx.input.KeyScancodeRecord;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiScreen;

public class Cls {
   private int int_;
   private static final char CHAR = '•';
   private Consumer<String> consumer;
   private String string;
   private int int_2;
   private Cls.NoneInsertEnum noneInsertEnum;
   private final Deque<Cls.TextCaretRecord> deque = new ArrayDeque<>();
   private Runnable runnable;
   private static final int INT = 128;
   public static final float FLOAT = 1000.0F;
   private final Deque<Cls.TextCaretRecord> deque2 = new ArrayDeque<>();
   private Runnable runnable2;
   private boolean bool;
   private float float_;
   private float float_2;
   private static final float FLOAT2 = 550.0F;

   public void handleConsumer(Consumer<String> var1) {
      this.consumer = var1;
   }

   private Cls.TextCaretRecord getTextCaretRecord() {
      String var1 = this.string;
      return new Cls.TextCaretRecord(var1, this.int_2, this.int_);
   }

   public boolean isEnabled2() {
      if (this.deque2.isEmpty()) {
         return false;
      } else {
         this.deque.push(this.getTextCaretRecord());
         this.handleTextCaretRecord(this.deque2.pop());
         return true;
      }
   }

   private int getInt6(int var1) {
      int var2;
      int var10000 = var2 = Math.clamp((long)var1, 0, this.string.length());

      while (var10000 < this.string.length() && !Character.isLetterOrDigit(this.string.charAt(var2))) {
         var10000 = ++var2;
      }

      var10000 = var2;

      while (var10000 < this.string.length() && Character.isLetterOrDigit(this.string.charAt(var2))) {
         var10000 = ++var2;
      }

      return var2;
   }

   public void run() {
      this.float_2 = 0.0F;
   }

   public void run3() {
      this.int_ = 0;
      this.int_2 = this.string.length();
      this.run();
   }

   public boolean isEnabled8() {
      return this.float_2 < 500.0F;
   }

   public int getInt() {
      return this.int_2;
   }

   public boolean isEnabled6() {
      if (this.deque.isEmpty()) {
         return false;
      } else {
         this.deque2.push(this.getTextCaretRecord());
         this.handleTextCaretRecord(this.deque.pop());
         return true;
      }
   }

   public float getFloat(int var1, Cls.Iface var2) {
      String var4 = this.getString();
      return var2.getFloat(var4.substring(0, Math.clamp((long)var1, 0, var4.length())));
   }

   public void handleBool(boolean var1) {
      this.bool = var1;
   }

   public void handleInt(int var1) {
      this.int_ = this.getInt4(Math.clamp((long)var1, 0, this.string.length()));
      this.int_2 = this.getInt6(Math.clamp((long)var1, 0, this.string.length()));
      this.run();
   }

   public String getString() {
      return this.bool ? String.valueOf('•').repeat(this.string.length()) : this.string;
   }

   public void handleInt2(int var1, boolean var2) {
      this.int_2 = Math.clamp((long)var1, 0, this.string.length());
      if (!var2) {
         int var3 = this.int_2;
         this.int_ = var3;
      }

      this.run();
   }

   private int getInt4(int var1) {
      int var2;
      int var10000 = var2 = Math.clamp((long)var1, 0, this.string.length());

      while (var10000 > 0 && !Character.isLetterOrDigit(this.string.charAt(var2 - 1))) {
         var10000 = --var2;
      }

      var10000 = var2;

      while (var10000 > 0 && Character.isLetterOrDigit(this.string.charAt(var2 - 1))) {
         var10000 = --var2;
      }

      return var2;
   }

   private void handleNoneInsertEnum(Cls.NoneInsertEnum var1) {
      boolean var3 = var1 == this.noneInsertEnum && this.float_ < 550.0F && !this.deque.isEmpty();
      if (!var3) {
         Cls var10000 = this;
         this.deque.push(this.getTextCaretRecord());

         while (var10000.deque.size() > 128) {
            var10000 = this;
            this.deque.removeLast();
         }
      }

      this.deque2.clear();
      this.noneInsertEnum = var1;
      this.float_ = 0.0F;
   }

   public void handleString(String var1) {
      this.handleString4(var1);
   }

   public boolean isKeyScancodeRecord(KeyScancodeRecord var1) {
      if (Util2.isKeyScancodeRecord7(var1, 30)) {
         this.run3();
         return true;
      } else if (Util2.isKeyScancodeRecord7(var1, 46)) {
         this.isEnabled3();
         return true;
      } else if (Util2.isKeyScancodeRecord7(var1, 45)) {
         if (this.isEnabled3()) {
            this.handleString3("", Cls.NoneInsertEnum.DELETE);
         }

         return true;
      } else if (Util2.isKeyScancodeRecord7(var1, 47)) {
         String var5 = GuiScreen.getClipboardString();
         this.handleString4(var5 == null ? "" : var5.replaceAll("[\\r\\n]", " "));
         return true;
      } else if (Util2.isKeyScancodeRecord(var1)) {
         return this.isEnabled6();
      } else if (Util2.isKeyScancodeRecord4(var1)) {
         return this.isEnabled2();
      } else {
         boolean var2 = var1.isEnabled3();
         switch (var1.key()) {
            case 1:

               if (this.runnable != null) {
                  this.runnable.run();
               }

               return true;
            case 14:
               if (this.isEnabled()) {
                  this.handleString3("", Cls.NoneInsertEnum.DELETE);
               } else if (this.int_2 > 0) {
                  this.int_ = Util2.isKeyScancodeRecord8(var1) ? this.getInt4(this.int_2) : this.int_2 - 1;
                  this.handleString3("", Cls.NoneInsertEnum.DELETE);
               }

               return true;
            case 28:
            case 156:
               if (this.runnable2 != null) {
                  this.runnable2.run();
               }

               return true;
            case 199:
               this.handleInt2(0, var2);
               return true;
            case 203:
               int var6;
               boolean var7;
               if (Util2.isKeyScancodeRecord8(var1)) {
                  var6 = this.getInt4(this.int_2);
                  var7 = var2;
               } else {
                  var6 = this.int_2 - 1;
                  var7 = var2;
               }

               this.handleInt2(var6, var7);
               return true;
            case 205:
               int var10001;
               boolean var10002;
               if (Util2.isKeyScancodeRecord8(var1)) {
                  var10001 = this.getInt6(this.int_2);
                  var10002 = var2;
               } else {
                  var10001 = this.int_2 + 1;
                  var10002 = var2;
               }

               this.handleInt2(var10001, var10002);
               return true;
            case 207:
               int var4 = this.string.length();
               this.handleInt2(var4, var2);
               return true;
            case 211:
               if (this.isEnabled()) {
                  this.handleString3("", Cls.NoneInsertEnum.DELETE);
               } else if (this.int_2 < this.string.length()) {
                  this.int_ = Util2.isKeyScancodeRecord8(var1) ? this.getInt6(this.int_2) : this.int_2 + 1;
                  this.handleString3("", Cls.NoneInsertEnum.DELETE);
               }

               return true;
            default:
               return false;
         }
      }
   }

   private boolean isEnabled3() {
      String var2 = this.isEnabled() ? this.getString3() : this.string;
      if (!this.bool && !var2.isEmpty()) {
         GuiScreen.setClipboardString(var2);
         return true;
      } else {
         return false;
      }
   }

   private void handleString4(String var1) {
      if (!var1.isEmpty()) {
         this.handleString3(var1, Cls.NoneInsertEnum.INSERT);
      }
   }

   public void handleString2(String var1) {
      this.string = var1 == null ? "" : var1;
      this.int_2 = this.string.length();
      this.int_ = this.int_2;
      this.float_2 = 0.0F;
      this.deque.clear();
      this.deque2.clear();
      this.noneInsertEnum = Cls.NoneInsertEnum.NONE;
   }

   public Cls() {
      this.string = "";
      this.float_ = Float.MAX_VALUE;
      this.noneInsertEnum = Cls.NoneInsertEnum.NONE;
   }

   public String getString3() {
      return this.isEnabled() ? this.string.substring(this.getInt2(), this.getInt5()) : "";
   }

   private void handleString3(String var1, Cls.NoneInsertEnum var2) {
      int var5 = this.getInt2();
      int var4 = this.getInt5();
      if (var5 != var4 || !var1.isEmpty()) {
         this.handleNoneInsertEnum(var2);
         this.string = this.string.substring(0, var5) + var1 + this.string.substring(var4);
         this.int_2 = var5 + var1.length();
         this.int_ = this.int_2;
         this.float_2 = 0.0F;
         if (this.consumer != null) {
            this.consumer.accept(this.string);
         }
      }
   }

   public void handleRunnable2(Runnable var1) {
      this.runnable2 = var1;
   }

   private void handleTextCaretRecord(Cls.TextCaretRecord var1) {
      this.string = var1.text();
      this.int_2 = Math.clamp((long)var1.caret(), 0, this.string.length());
      this.int_ = Math.clamp((long)var1.anchor(), 0, this.string.length());
      this.float_2 = 0.0F;
      this.noneInsertEnum = Cls.NoneInsertEnum.NONE;
      this.float_ = Float.MAX_VALUE;
      if (this.consumer != null) {
         this.consumer.accept(this.string);
      }
   }

   public static String decrypt(String var0) {
      int var10001 = 3 << 3 ^ 7;
      String var10;
      int var10003 = (var10 = var0).length();
      char[] var10004 = new char[var10003];
      boolean var10006 = true;
      int var5;
      int var10002 = var5 = var10003 - 1;
      char[] var1 = var10004;
      byte var4 = 117;
      int var10000 = var10002;

      for (byte var2 = 49; var10000 >= 0; var10000 = var5) {
         char var6 = var10.charAt(var5);
         int var7 = var5--;
         char var9 = (char)(var6 ^ var2);
         var1[var7] = var9;
         if (var5 < 0) {
            break;
         }

         var10002 = var5--;
         var1[var10002] = (char)(var10.charAt(var10002) ^ var4);
      }

      return new String(var1);
   }

   public void handleRunnable(Runnable var1) {
      this.runnable = var1;
   }

   public String getString2() {
      return this.string;
   }

   public boolean isEnabled7() {
      return this.bool;
   }

   public boolean isEnabled() {
      return this.int_2 != this.int_;
   }

   public void run2() {
      this.int_ = this.int_2;
      this.run();
   }

   public boolean isEnabled5() {
      if (this.string.isEmpty()) {
         return false;
      } else {
         this.run3();
         this.handleString3("", Cls.NoneInsertEnum.DELETE);
         return true;
      }
   }

   public int getInt5() {
      return Math.max(this.int_2, this.int_);
   }

   public boolean isCodepointModifiersRecord(CodepointModifiersRecord var1) {
      if (!Util2.isCodepointModifiersRecord(var1)) {
         return false;
      } else {
         this.handleString4(Character.toString(var1.codepoint()));
         return true;
      }
   }

   public int getInt3(float var1, Cls.Iface var2) {
      String var6 = this.getString();
      int var4 = 0;
      float var5 = Math.abs(var1);

      int var8;
      for (int var10000 = var8 = 1; var10000 <= var6.length(); var10000 = ++var8) {
         float var7;
         if ((var7 = Math.abs(var2.getFloat(var6.substring(0, var8)) - var1)) <= var5) {
            var5 = var7;
            var4 = var8;
         }
      }

      return var4;
   }

   public float getFloat2(Cls.Iface var1) {
      String var3 = this.getString();
      int var4 = this.int_2;
      int var5 = var3.length();
      int var6 = Math.min(var4, var5);
      String var7 = var3.substring(0, var6);
      return var1.getFloat(var7);
   }

   public boolean isEnabled4() {
      return this.string.isEmpty();
   }

   public int getInt2() {
      return Math.min(this.int_2, this.int_);
   }

   public void handleFloat(float var1) {
      this.float_2 = (this.float_2 + var1) % 1000.0F;
      if (this.float_ < Float.MAX_VALUE) {
         float var3 = this.float_ + var1;
         this.float_ = var3;
      }
   }

   public interface Iface {
      float getFloat(String var1);
   }

   private static enum NoneInsertEnum {
      // 顺序按原 $VALUES 数组（即 ordinal）
      NONE,
      INSERT,
      DELETE;

   }

   private record TextCaretRecord(String text, int caret, int anchor) {
   }
}
