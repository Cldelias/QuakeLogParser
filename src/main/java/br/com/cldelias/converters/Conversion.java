package br.com.cldelias.converters;

public interface Conversion<T> {

	public T converter(String line);
}
