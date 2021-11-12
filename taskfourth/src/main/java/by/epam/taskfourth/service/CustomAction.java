package by.epam.taskfourth.service;

import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.LeafSymbol;
import by.epam.taskfourth.composite.TypeComponent;

import java.util.*;
import java.util.stream.Collectors;

public class CustomAction {
    static final String SYMBOL_VOWEL = "[eyuioaEYUIOAуеыаоэяиюУЕЫАОЭЯИЮ]";

    /**
     *
     * @param composite object of text elements
     * @param comparator
     * @return sorted list of elements by paragraphs
     */
    public List<Composite> sortParagraphs(Composite composite, Comparator<Composite> comparator){
        List<Composite> components = composite.getComposites();
        return components.stream().sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param composite
     * @param mapSentences
     */
    public void findSentenceByMaxWord(Composite composite,Map<String,Integer> mapSentences){
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.SENTENCE){
                int maxSize = maxSizeWord(element);
                mapSentences.put(element.toString(),maxSize);
            }else{
                findSentenceByMaxWord(element,mapSentences);
            }
        }
        if(composite.getTypeComponent()==TypeComponent.TEXT){
            int maxSizeWord = maxSizeWord(composite);
            Iterator<String> iterator = mapSentences.keySet().iterator();
            while (iterator.hasNext()) {
                String sentence = iterator.next();
                if (mapSentences.get(sentence) < maxSizeWord) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * private method for searching a maximum word from composite
     * @param composite an object of text elements
     * @return max size of a word
     */
    private int maxSizeWord(Composite composite){
        int maxSize = 0;
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.WORD){
                List<Composite> wordsList = element.getComposites();
                maxSize = wordsList.size();
            }else if(element.getTypeComponent()!=TypeComponent.PUNCT){
                if(maxSize<maxSizeWord(element)){
                    maxSize=maxSizeWord(element);
                }
            }
        }
        return maxSize;
    }

    /**
     *
     * @param composite
     * @param length
     */
    public void removeWordByLength(Composite composite, int length){
        List<Composite> components = composite.getComposites();
        Iterator<Composite> iterator = components.iterator();
        while(iterator.hasNext()){
            Composite component = iterator.next();
            if(component.getTypeComponent()==TypeComponent.WORD){
                List<Composite> wordComponents = component.getComposites();
                if(wordComponents.size()==length){
                    iterator.remove();
                }
            }else if(component.getTypeComponent()!=TypeComponent.SYMBOL &&
                    component.getTypeComponent()!=TypeComponent.PUNCT){
                removeWordByLength(component,length);
            }
        }
    }

    /**
     *
     * @param composite
     * @param length
     */
    public void removeSentenceByLength(Composite composite, int length){
        int count = 0;
        List<Composite> components = composite.getComposites();
        Iterator<Composite> iterator = components.iterator();
        while(iterator.hasNext()){
            Composite component = iterator.next();
            if(component.getTypeComponent()==TypeComponent.SENTENCE){
                count = findWordFromSentence(component);
                if(count<length){
                    iterator.remove();
                }
            }else {
                removeSentenceByLength(component,length);
            }
        }
    }

    /**
     *
     * @param composite
     * @return
     */
    private int findWordFromSentence(Composite composite){
        int result = 0;
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.WORD){
                result++;
            }else if(element.getTypeComponent()!=TypeComponent.PUNCT){
                result+=findWordFromSentence(element);
            }
        }
        return result;
    }

    /**
     *
     * @param composite
     * @param mapWord
     */
    public void findValueRepeatWords(Composite composite, Map<String,Integer> mapWord){
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.WORD){
                String word = element.toString().toLowerCase();
                if(mapWord.isEmpty() || !mapWord.containsKey(word)){
                    mapWord.put(word,1);
                }else if(mapWord.containsKey(word)){
                    int value = mapWord.get(word);
                    mapWord.put(word,++value);
                }
            }else if(element.getTypeComponent()!=TypeComponent.PUNCT){
                findValueRepeatWords(element,mapWord);
            }
        }
        if(composite.getTypeComponent()==TypeComponent.TEXT) {
            Iterator<String> iterator = mapWord.keySet().iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (mapWord.get(word) == 1) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     *
     * @param composite
     * @return
     */
    private int symbolsVowel(Composite composite){
        int count = 0;
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.SYMBOL ||
                    element.getTypeComponent()==TypeComponent.PUNCT){
                LeafSymbol symbol = (LeafSymbol)element;
                if (Character.toString(symbol.getSymbol()).matches(SYMBOL_VOWEL)){
                    count++;
                }
            }else{
                count+= symbolsVowel(element);
            }
        }
        return count;
    }

    /**
     *
     * @param composite
     * @return
     */
    private int symbolsConsonant(Composite composite){
        int count = 0;
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.SYMBOL ||
                    element.getTypeComponent()==TypeComponent.PUNCT){
                LeafSymbol symbol = (LeafSymbol)element;
                if (!Character.toString(symbol.getSymbol()).matches(SYMBOL_VOWEL) &&
                symbol.getTypeComponent()!=TypeComponent.PUNCT){
                    count++;
                }
            }else{
                count+=symbolsConsonant(element);
            }
        }
        return count;
    }

    /**
     *
     * @param composite
     * @param map
     */
    public void symbolsConsonantFromSentence(Composite composite, Map<String,Integer> map){
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.SENTENCE){
                int count = symbolsConsonant(element);
                map.put(element.toString(),count);
            }else{
                symbolsConsonantFromSentence(element,map);
            }
        }
    }

    /**
     *
     * @param composite
     * @param map
     */
    public void symbolsVowelFromSentence(Composite composite, Map<String,Integer> map){
        List<Composite> components = composite.getComposites();
        for(Composite element: components){
            if(element.getTypeComponent()==TypeComponent.SENTENCE){
                int count = symbolsVowel(element);
                map.put(element.toString(),count);
            }else{
                symbolsConsonantFromSentence(element,map);
            }
        }
    }
}
