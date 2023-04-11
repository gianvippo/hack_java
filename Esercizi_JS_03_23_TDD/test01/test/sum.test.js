import sum from "./../src/sum"

describe("sum", () => {

    it("should return 2 for 1 and 1", () => {

        expect(sum(1, 1)).toBe(2)

    })

    it("should return other number if one of them is o", () => {

        expect(sum(0, 3)).toBe(3)
        expect(sum(4, 0)).toBe(4)
    })

    
})