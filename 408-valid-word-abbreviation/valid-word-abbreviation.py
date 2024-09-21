class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        word_ptr = 0
        abbr_ptr = 0
        
        while word_ptr < len(word) and abbr_ptr < len(abbr):
            if abbr[abbr_ptr].isdigit():  # Corrected here
                steps = 0
                if abbr[abbr_ptr] == "0":  # Abbreviation cannot start with 0
                    return False
                while abbr_ptr < len(abbr) and abbr[abbr_ptr].isdigit():  # Fixed the isdigit check
                    steps = steps * 10 + int(abbr[abbr_ptr])  # Convert digits to an integer
                    abbr_ptr += 1
                
                word_ptr += steps  # Skip characters in 'word' by 'steps'
            else:
                if word_ptr >= len(word) or word[word_ptr] != abbr[abbr_ptr]:
                    return False  # Mismatch between characters in 'word' and 'abbr'
                    
                word_ptr += 1
                abbr_ptr += 1
        
        return word_ptr == len(word) and abbr_ptr == len(abbr)
