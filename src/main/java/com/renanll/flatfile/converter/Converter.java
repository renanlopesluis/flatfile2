package com.renanll.flatfile.converter;

public interface Converter<T> {
	T convert(String row) throws Exception;
}
