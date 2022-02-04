package ii887522.oxy.any

import ii887522.oxy.struct.*
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class JsonLexerTest {
  @Test fun `test lex`() {
    assertArrayEquals(arrayOf(), "".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a')), "a".lex())
    assertArrayEquals(arrayOf(CharJsonToken('b')), "b".lex())
    assertArrayEquals(arrayOf(CharJsonToken('c')), "c".lex())
    assertArrayEquals(arrayOf(CharJsonToken('c'), CharJsonToken('a')), "ca".lex())
    assertArrayEquals(arrayOf(CharJsonToken('c'), CharJsonToken('b')), "cb".lex())
    assertArrayEquals(arrayOf(CharJsonToken('d'), CharJsonToken('b')), "db".lex())
    assertArrayEquals(arrayOf(CharJsonToken('d'), CharJsonToken('b'), CharJsonToken('a')), "dba".lex())
    assertArrayEquals(arrayOf(CommaJsonToken), ",".lex())
    assertArrayEquals(arrayOf(CommaJsonToken, CharJsonToken('a')), ",a".lex())
    assertArrayEquals(arrayOf(CommaJsonToken, CharJsonToken('a'), CommaJsonToken), ",a,".lex())
    assertArrayEquals(arrayOf(CommaJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), ",a,b".lex())
    assertArrayEquals(arrayOf(CommaJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), CommaJsonToken), ",a,b,".lex())
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken), "[".lex())
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken, CharJsonToken('a')), "[a".lex())
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken), "[a,".lex())
    assertArrayEquals(arrayOf(LeftSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), "[a,b".lex())
    assertArrayEquals(
      arrayOf(LeftSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), LeftSquareBracketJsonToken), "[a,b[".lex()
    )
    assertArrayEquals(arrayOf(RightSquareBracketJsonToken), "]".lex())
    assertArrayEquals(arrayOf(RightSquareBracketJsonToken, CharJsonToken('a')), "]a".lex())
    assertArrayEquals(arrayOf(RightSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken), "]a,".lex())
    assertArrayEquals(arrayOf(RightSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), "]a,b".lex())
    assertArrayEquals(
      arrayOf(RightSquareBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), RightSquareBracketJsonToken), "]a,b]".lex()
    )
    assertArrayEquals(arrayOf(ColonJsonToken), ":".lex())
    assertArrayEquals(arrayOf(ColonJsonToken, CharJsonToken('a')), ":a".lex())
    assertArrayEquals(arrayOf(ColonJsonToken, CharJsonToken('a'), CommaJsonToken), ":a,".lex())
    assertArrayEquals(arrayOf(ColonJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), ":a,b".lex())
    assertArrayEquals(arrayOf(ColonJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), ColonJsonToken), ":a,b:".lex())
    assertArrayEquals(arrayOf(LeftCurlyBracketJsonToken), "{".lex())
    assertArrayEquals(arrayOf(LeftCurlyBracketJsonToken, CharJsonToken('a')), "{a".lex())
    assertArrayEquals(arrayOf(LeftCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken), "{a,".lex())
    assertArrayEquals(arrayOf(LeftCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), "{a,b".lex())
    assertArrayEquals(
      arrayOf(LeftCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), LeftCurlyBracketJsonToken), "{a,b{".lex()
    )
    assertArrayEquals(arrayOf(RightCurlyBracketJsonToken), "}".lex())
    assertArrayEquals(arrayOf(RightCurlyBracketJsonToken, CharJsonToken('a')), "}a".lex())
    assertArrayEquals(arrayOf(RightCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken), "}a,".lex())
    assertArrayEquals(arrayOf(RightCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b')), "}a,b".lex())
    assertArrayEquals(
      arrayOf(RightCurlyBracketJsonToken, CharJsonToken('a'), CommaJsonToken, CharJsonToken('b'), RightCurlyBracketJsonToken), "}a,b}".lex()
    )
    assertArrayEquals(arrayOf(CharJsonToken('n')), "n".lex())
    assertArrayEquals(arrayOf(CharJsonToken('n'), CharJsonToken('u')), "nu".lex())
    assertArrayEquals(arrayOf(CharJsonToken('n'), CharJsonToken('u'), CharJsonToken('l')), "nul".lex())
    assertArrayEquals(arrayOf(NullJsonToken), "null".lex())
    assertArrayEquals(arrayOf(NullJsonToken, NullJsonToken), "null null".lex())
    assertArrayEquals(arrayOf(NullJsonToken, NullJsonToken, NullJsonToken), "null null null".lex())
    assertArrayEquals(
      arrayOf(NullJsonToken, CharJsonToken('n'), CharJsonToken('u'), CharJsonToken('l'), CharJsonToken('a'), NullJsonToken),
      "null nula null".lex()
    )
    assertArrayEquals(arrayOf(NullJsonToken, CharJsonToken('n'), CharJsonToken('u'), CharJsonToken('a'), NullJsonToken), "null nua null".lex())
    assertArrayEquals(arrayOf(NullJsonToken, CharJsonToken('n'), CharJsonToken('b'), CharJsonToken('a'), NullJsonToken), "null nba null".lex())
    assertArrayEquals(arrayOf(NullJsonToken, CharJsonToken('b'), CharJsonToken('a'), NullJsonToken), "null ba null".lex())
    assertArrayEquals(
      arrayOf(NullJsonToken, CharJsonToken('n'), CharJsonToken('u'), CharJsonToken('l'), CommaJsonToken, NullJsonToken), "null nul, null".lex()
    )
    assertArrayEquals(arrayOf(CharJsonToken('t')), "t".lex())
    assertArrayEquals(arrayOf(CharJsonToken('t'), CharJsonToken('r')), "tr".lex())
    assertArrayEquals(arrayOf(CharJsonToken('t'), CharJsonToken('r'), CharJsonToken('u')), "tru".lex())
    assertArrayEquals(arrayOf(TrueJsonToken), "true".lex())
    assertArrayEquals(arrayOf(TrueJsonToken, TrueJsonToken), "true true".lex())
    assertArrayEquals(arrayOf(TrueJsonToken, TrueJsonToken, TrueJsonToken), "true true true".lex())
    assertArrayEquals(
      arrayOf(TrueJsonToken, CharJsonToken('t'), CharJsonToken('r'), CharJsonToken('u'), CharJsonToken('a'), TrueJsonToken),
      "true trua true".lex()
    )
    assertArrayEquals(arrayOf(TrueJsonToken, CharJsonToken('t'), CharJsonToken('r'), CharJsonToken('a'), TrueJsonToken), "true tra true".lex())
    assertArrayEquals(arrayOf(TrueJsonToken, CharJsonToken('t'), CharJsonToken('b'), CharJsonToken('a'), TrueJsonToken), "true tba true".lex())
    assertArrayEquals(arrayOf(TrueJsonToken, CharJsonToken('b'), CharJsonToken('a'), TrueJsonToken), "true ba true".lex())
    assertArrayEquals(
      arrayOf(TrueJsonToken, CharJsonToken('t'), CharJsonToken('r'), CharJsonToken('u'), CommaJsonToken, TrueJsonToken), "true tru, true".lex()
    )
    assertArrayEquals(arrayOf(CharJsonToken('f')), "f".lex())
    assertArrayEquals(arrayOf(CharJsonToken('f'), CharJsonToken('a')), "fa".lex())
    assertArrayEquals(arrayOf(CharJsonToken('f'), CharJsonToken('a'), CharJsonToken('l')), "fal".lex())
    assertArrayEquals(arrayOf(CharJsonToken('f'), CharJsonToken('a'), CharJsonToken('l'), CharJsonToken('s')), "fals".lex())
    assertArrayEquals(arrayOf(FalseJsonToken), "false".lex())
    assertArrayEquals(arrayOf(FalseJsonToken, FalseJsonToken), "false false".lex())
    assertArrayEquals(arrayOf(FalseJsonToken, FalseJsonToken, FalseJsonToken), "false false false".lex())
    assertArrayEquals(
      arrayOf(
        FalseJsonToken,
        CharJsonToken('f'),
        CharJsonToken('a'),
        CharJsonToken('l'),
        CharJsonToken('s'),
        CharJsonToken('a'),
        FalseJsonToken
      ),
      "false falsa false".lex()
    )
    assertArrayEquals(
      arrayOf(FalseJsonToken, CharJsonToken('f'), CharJsonToken('a'), CharJsonToken('l'), CharJsonToken('a'), FalseJsonToken),
      "false fala false".lex()
    )
    assertArrayEquals(
      arrayOf(FalseJsonToken, CharJsonToken('f'), CharJsonToken('a'), CharJsonToken('b'), CharJsonToken('a'), FalseJsonToken),
      "false faba false".lex()
    )
    assertArrayEquals(arrayOf(FalseJsonToken, CharJsonToken('f'), CharJsonToken('b'), CharJsonToken('a'), FalseJsonToken), "false fba false".lex())
    assertArrayEquals(arrayOf(FalseJsonToken, CharJsonToken('b'), CharJsonToken('a'), FalseJsonToken), "false ba false".lex())
    assertArrayEquals(
      arrayOf(FalseJsonToken, CharJsonToken('f'), CharJsonToken('a'), CharJsonToken('l'), CharJsonToken('s'), CommaJsonToken, FalseJsonToken),
      "false fals, false".lex()
    )
    assertArrayEquals(arrayOf(SignJsonToken(SignJsonToken.Value.POSITIVE)), "+".lex())
    assertArrayEquals(arrayOf(SignJsonToken(SignJsonToken.Value.NEGATIVE)), "-".lex())
    assertArrayEquals(arrayOf(CharJsonToken('*')), "*".lex())
    assertArrayEquals(arrayOf(CommaJsonToken), ",".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(0f)), "0".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(1f)), "1".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(2f)), "2".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(3f)), "3".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(4f)), "4".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(5f)), "5".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(6f)), "6".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(7f)), "7".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(8f)), "8".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(9f)), "9".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(9f)), "9,9".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7f)), "9,8,7".lex())
    assertArrayEquals(arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7f)), "9,8,7.".lex())
    assertArrayEquals(
      arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7f), CharJsonToken('a')),
      "9,8,7.a".lex()
    )
    assertArrayEquals(
      arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7f)),
      "9,8,7.0".lex()
    )
    assertArrayEquals(
      arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7.1f)),
      "9,8,7.1".lex()
    )
    assertArrayEquals(
      arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(7.2f)),
      "9,8,7.2".lex()
    )
    assertArrayEquals(
      arrayOf(NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f)),
      "9,8,-7.2".lex()
    )
    assertArrayEquals(
      arrayOf(CharJsonToken('a'), NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f)),
      "a9,8,-7.2".lex()
    )
    assertArrayEquals(
      arrayOf(
        CharJsonToken('a'),
        NumberJsonToken(9f),
        CommaJsonToken,
        NumberJsonToken(8f),
        CommaJsonToken,
        NumberJsonToken(-7.2f),
        CharJsonToken('b')
      ),
      "a9,8,-7.2b".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f)),
      ",9,8,-7.2".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-7.2f), CommaJsonToken),
      ",9,8,-7.2,".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-70.2f), CommaJsonToken),
      ",9,8,-70.2,".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-701.2f), CommaJsonToken),
      ",9,8,-701.2,".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-701.02f), CommaJsonToken),
      ",9,8,-701.02,".lex()
    )
    assertArrayEquals(
      arrayOf(CommaJsonToken, NumberJsonToken(9f), CommaJsonToken, NumberJsonToken(8f), CommaJsonToken, NumberJsonToken(-701.021f), CommaJsonToken),
      ",9,8,-701.021,".lex()
    )
    assertArrayEquals(arrayOf(CharJsonToken('"')), "\"".lex())
    assertArrayEquals(arrayOf(StringJsonToken("")), "\"\"".lex())
    assertArrayEquals(arrayOf(StringJsonToken("a")), "\"a\"".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a'), StringJsonToken("")), "a\"\"".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a'), StringJsonToken(""), CommaJsonToken), "a\"\",".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a'), StringJsonToken("b"), CommaJsonToken), "a\"b\",".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a'), StringJsonToken("bc"), CommaJsonToken), "a\"bc\",".lex())
    assertArrayEquals(arrayOf(CharJsonToken('a'), StringJsonToken("bcd"), CommaJsonToken), "a\"bcd\",".lex())
    assertArrayEquals(
      arrayOf(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("javascript.validate.enable"),
        ColonJsonToken,
        FalseJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.usePackageJson"),
        ColonJsonToken,
        TrueJsonToken,
        CommaJsonToken,
        KeyJsonToken("standard.engine"),
        ColonJsonToken,
        StringJsonToken("ts-standard"),
        CommaJsonToken,
        KeyJsonToken("standard.validate"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        StringJsonToken("javascript"),
        RightSquareBracketJsonToken,
        RightCurlyBracketJsonToken
      ),
      """{
  "javascript.validate.enable": false,
  "standard.usePackageJson": true,
  "standard.engine": "ts-standard",
  "standard.validate": ["javascript"]
}
""".lex()
    )
    assertArrayEquals(
      arrayOf(
        LeftCurlyBracketJsonToken,
        KeyJsonToken("keyPath"),
        ColonJsonToken,
        StringJsonToken("test/key.pem"),
        CommaJsonToken,
        KeyJsonToken("certPath"),
        ColonJsonToken,
        StringJsonToken("test/cert.pem"),
        CommaJsonToken,
        KeyJsonToken("routes"),
        ColonJsonToken,
        LeftSquareBracketJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("hostname"),
        ColonJsonToken,
        StringJsonToken("example.dynv6.net"),
        CommaJsonToken,
        KeyJsonToken("target"),
        ColonJsonToken,
        StringJsonToken("http://localhost:1024"),
        RightCurlyBracketJsonToken,
        CommaJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("hostname"),
        ColonJsonToken,
        StringJsonToken("www.example.dynv6.net"),
        CommaJsonToken,
        KeyJsonToken("target"),
        ColonJsonToken,
        StringJsonToken("http://localhost:1024"),
        RightCurlyBracketJsonToken,
        CommaJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("hostname"),
        ColonJsonToken,
        StringJsonToken("abcdefg.dynv6.net"),
        CommaJsonToken,
        KeyJsonToken("targetScheme"),
        ColonJsonToken,
        StringJsonToken("http"),
        CommaJsonToken,
        KeyJsonToken("targetHostname"),
        ColonJsonToken,
        StringJsonToken("localhost"),
        CommaJsonToken,
        KeyJsonToken("targetPort"),
        ColonJsonToken,
        NumberJsonToken(1025f),
        RightCurlyBracketJsonToken,
        CommaJsonToken,
        LeftCurlyBracketJsonToken,
        KeyJsonToken("hostname"),
        ColonJsonToken,
        StringJsonToken("www.abcdefg.dynv6.net"),
        CommaJsonToken,
        KeyJsonToken("target"),
        ColonJsonToken,
        NullJsonToken,
        RightCurlyBracketJsonToken,
        RightSquareBracketJsonToken,
        RightCurlyBracketJsonToken
      ),
      """{
  "keyPath": "test/key.pem",
  "certPath": "test/cert.pem",
  "routes": [
    {
      "hostname": "example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "www.example.dynv6.net",
      "target": "http://localhost:1024"
    },
    {
      "hostname": "abcdefg.dynv6.net",
      "targetScheme": "http",
      "targetHostname": "localhost",
      "targetPort": 1025
    },
    {
      "hostname": "www.abcdefg.dynv6.net",
      "target": null
    }
  ]
}
""".lex()
    )
  }
}
