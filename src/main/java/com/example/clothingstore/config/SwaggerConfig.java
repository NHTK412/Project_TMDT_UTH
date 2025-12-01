package com.example.clothingstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                final String securitySchemeName = "Bearer-Auth";

                return new OpenAPI()
                                .info(new Info() // Cung cấp thông tin về API
                                                .title("Clothing Store API")
                                                .version("1.0.0")
                                                .description("API documentation for Clothing Store")) // Mô tả về API
                                .components(new io.swagger.v3.oas.models.Components() // Dùng để khai báo các thành phần
                                                                                      // tái sử dụng
                                                                                      // trong OpenAPI
                                                .addSecuritySchemes(securitySchemeName, // Tên của sơ đồ bảo mật
                                                                new SecurityScheme()
                                                                                .name(securitySchemeName) // Tên hiển
                                                                                                          // thị của sơ
                                                                                                          // đồ bảo mật
                                                                                .type(Type.HTTP) // Loại sơ đồ bảo mật
                                                                                                 // (HTTP)
                                                                                .scheme("bearer") // Sơ đồ sử dụng
                                                                                                  // Bearer token
                                                                                .bearerFormat("JWT") // Định dạng của
                                                                                                     // token là JWT
                                                                                .in(In.HEADER))) // Vị trí của token
                                                                                                 // trong header
                                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)); // Thêm yêu cầu
                                                                                                         // bảo mật sử
                                                                                                         // dụng
                                                                                                         // sơ đồ bảo
                                                                                                         // mật đã định
                                                                                                         // nghĩa
        }
}
