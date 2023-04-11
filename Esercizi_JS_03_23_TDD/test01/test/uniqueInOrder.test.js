import uniqueInOrder from "../src/uniqueInOrder"

describe("uniqueInOrder", () => {

    it("should return an array", () => {
        expect(Array.isArray(uniqueInOrder("string"))).toBe(true)
    })

    it("should return an array with 1 char per element", () => {

        expect(uniqueInOrder("string")[0].length).toBe(1)
        expect(uniqueInOrder("stringa")[3].length).toBe(1)

    })

    it("should return a list of items without any elements with the same value next to each other and preserving the original order of elements", () => {

        expect(uniqueInOrder("AAAABBBCCCc")).toStrictEqual(['A','B','C','c'])
        expect(uniqueInOrder("AAAABBBCCCcAAB")).toStrictEqual(['A','B','C','c','A','B'])
        expect(uniqueInOrder([1,2,2,2,3,3,4,4,5])).toStrictEqual([1,2,3,4,5])
        
    })
})