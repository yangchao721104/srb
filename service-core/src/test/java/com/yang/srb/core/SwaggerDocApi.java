package com.yang.srb.core;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

/**
 * @author yang
 * @date 2022/7/18 14:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerDocApi {

    /**
     * 生成AsciiDocs格式文档
     *
     * @throws Exception
     */
    @Test
    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8110/v2/api-docs?group=adminApi"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/asciidoc/generated"));
    }

    /**
     * 生成Markdown格式文档
     *
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocs() throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

//        Swagger2MarkupConverter.from(new URL("http://localhost:8016/v2/api-docs"))
        Swagger2MarkupConverter.from(new URL("http://localhost:8110/v2/api-docs?group=adminApi"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./docs/markdown/generated"));
    }

    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    @Test
    public void generateAsciiDocsToFile() throws Exception {
        //    输出Ascii到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8110/v2/api-docs?group=adminApi"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/asciidoc/generated/all"));
    }

    /**
     * 生成Markdown格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocsToFile() throws Exception {
        //    输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8110/v2/api-docs?group=adminApi"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/markdown/generated/all"));
    }


}
