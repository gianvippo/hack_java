import splitString from "../src/splitString"

describe("splitString", () => {

    it("should return an array", () => {

        expect(Array.isArray(splitString("string"))).toBe(true)

    })

    it("should return an array with max 2 char per element of array", () => {

        expect(splitString("string")[0].length).toBeLessThan(3)
        expect(splitString("string")[2].length).toBeLessThan(3)

    })

    it("should return an array with 2 char per element", () => {

        expect(splitString("string")[0].length).toBe(2)
        expect(splitString("stringa")[3].length).toBe(2)

    })

    it("should return an array with [\"ab\", \"cd\", \"ef\"]", () => {

        let array = ["ab", "cd", "ef"]

        expect(splitString("abcdef")).toStrictEqual(array)

    })

    it("should return an array with [\"ab\", \"c_\"]", () => {

        let array = ["ab", "c_"]

        expect(splitString("abc")).toStrictEqual(array)
        
    })
})