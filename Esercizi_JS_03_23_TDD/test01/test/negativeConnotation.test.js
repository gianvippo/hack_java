import negativeConnotation from "../src/negativeConnotation"

describe("negativeConnotation", () => {

    it("should return if there are more (or equal) positive words than negative words, false otherwise", () => {

        expect(negativeConnotation("Ciao mamma guarda come nuoto")).toBe(true)
        expect(negativeConnotation("Xilofono zorro nuoto come baita")).toBe(false)

    })
})