package com.example.ClyrafiGlassWallet.clyrafiWallet.utiles;

public class EnumValidator {
    public static <E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String value) {
        if (value == null) return false;
        try {
            Enum.valueOf(enumClass, value.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
