package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamPractise {

	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<String>();
		names.add("a");
		names.add("ab");
		names.add("abc");
		names.add("ohbom");
		names.add("hihi");
		
		streamFilter(names);
		streamMap(names);
		streamCollect();
	}
	
	@Test
	public static void streamFilter(ArrayList<String> names) {
		long cnt=names.stream().filter(s->s.startsWith("a")).count();
		System.out.println(cnt);
		
		long cnt2=Stream.of("a","ab","ohbom").filter(s->s.startsWith("a")).count();
		System.out.println(cnt2);
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	}
	
	@Test
	public static void streamMap(ArrayList<String> names) {
		// a로 끝나는 단어들만 대문자로 바꾸어서 프린트 
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(it->System.out.println(it));
		
		// A로 시작하는 단어들만 소문자로 바꾸어서 프린트 
		List <String> names2 = Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
		names2.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase()).forEach(it->System.out.println(it));
	
		// 2개의 리스트 병합
		Stream <String> newStream = Stream.concat(names.stream(), names2.stream());
		boolean flag=newStream.anyMatch(it->it.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);	
	}
	
	@Test
	public static void streamCollect() {
		List<String> ls=Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values=Arrays.asList(2,3,3,3,3,1,1,5);
		// unique number from array
		values.stream().distinct().forEach(it->System.out.println(it));
		
		// sort array , limit 2
		List<Integer> li=values.stream().distinct().sorted().limit(2).collect(Collectors.toList());
		System.out.println(li);
	}
	

}
