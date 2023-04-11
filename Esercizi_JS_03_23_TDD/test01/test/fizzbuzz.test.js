import fizzbuzz from "./../src/fizzbuzz"

describe("fizzbuzz", () => {

    it("should return 1 for 1", () => {

        expect(fizzbuzz(1)).toBe(1)

    })

    it("should return 16 for 16", () => {

        expect(fizzbuzz(16)).toBe(16)

    })

    it("should return \'fizz\' for numbers divisble by 3", () => {

        expect(fizzbuzz(6)).toBe("fizz")

    })

    it("should return \'buzz\' for numbers divisble by 5", () => {

        expect(fizzbuzz(10)).toBe("buzz")

    })

    it("should return \'fizzbuzz\' for numbers divisble by 5 and 3", () => {

        expect(fizzbuzz(15)).toBe("fizzbuzz")
        expect(fizzbuzz(30)).toBe("fizzbuzz")
        expect(fizzbuzz(45)).toBe("fizzbuzz")

    })
})