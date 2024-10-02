# Markov Chain Text Generator

This project implements a simple Markov Chain text generator in Java. The program reads an input text, builds a Markov chain, and generates new text based on the statistical properties of the input.

## What is a Markov Chain?

A Markov Chain is a stochastic process that transitions from one state to another based solely on the current state, without regard for the sequence of events that preceded it. In the context of text generation, the "states" are words, and the "transitions" are the probabilities of a word following a particular sequence of words.

In this implementation, a fixed-length sequence of words (known as a prefix) is used to predict the next word (suffix) based on the input text. The length of the prefix is defined as `NPREF` (in this case, 2 words).

## Shelly Corpus

The input text used in this project is a small text corpus inspired by atmospheric descriptions, often found in gothic fiction. It simulates the writing style of authors like Mary Shelley, providing an eerie, mysterious tone. The program uses this corpus to build its Markov chain and generate new text in a similar style.

### Example Corpus
Here is an excerpt of the input text:
```
The night was cold, dark.
Clouds covered the distant moon.
Wind swept through the trees.
Leaves rustled in soft whispers.
```

## How It Works

1. The program reads the input text and breaks it into words.
2. It constructs a Markov chain using a mapping from a prefix (two words) to a list of possible suffixes (next word).
3. The chain is then used to generate a sequence of words up to a specified limit (`MAXGEN`), producing new text that mimics the style of the input corpus.

## Running the Program

To run the program, execute the `Markov` class. The program will read the input text and generate a sequence of up to 8 words.

```bash
java Markov
```

The output will be a newly generated text sequence that follows the statistical structure of the input text.

## Customization

You can customize the following parameters:
- **Input Text**: Modify the `inputText` variable in the `Markov` class to use your own text corpus.
- **MAXGEN**: Change the `MAXGEN` variable to generate more or fewer words.
- **NPREF**: Adjust the length of the prefix in the `Chain` class for different levels of coherence in the generated text.
