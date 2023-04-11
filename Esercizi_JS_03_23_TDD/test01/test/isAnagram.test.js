import isAnagram from "../src/isAnagram"

describe("isAnagram", () => {

    it("should be the same lenght", () => {

        expect(isAnagram("abc", "ab")).toBe(false)
        expect(isAnagram("1234", "as")).toBe(false)

    })

    it("should return true if strings are the same", () => {

        expect(isAnagram("abc", "abc")).toBe(true)

    })

    it("is anagram where strings have same chars and same length", () => {

        expect(isAnagram("abc", "cba")).toBe(true)
        expect(isAnagram("patrie", "pietra")).toBe(true)
        expect(isAnagram("patrie", "parete")).toBe(false)
    })

    it("should return true if strings are the same but with different case", () => {

        expect(isAnagram("abC", "cba")).toBe(true)
    })

})