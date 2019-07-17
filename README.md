Autocorrect
Our main idea is to create an autocorrect system that'll do three things.

1. Autocomplete
Will suggest a full word based upon a word snippet from the user.
As the user types the system will take into account things like:
  - Alphabetical Order
    - As soon as the user has input "a" for example, the pool of suggestions will be comprised solely of words that start with "a". This would be the same case with "al" trimming the pool down to words that only start with "al".
  - Word Length
    - The autocomplete system will never suggest a word that has a length shorter than that of the input segment. It will also use word length to differentiate between ties in word frequency. It would do this by seeing that two (three, four, etc) words have the same fequency and the same starting string segment, but have different lengths. It would then suggest the shorter of the two words
  - Word Frequency
    - Our database has a pool of currently 400 thousand words along with their frequencies.
2. Whitespace
3. Levenshtein Edit Distance


Database


