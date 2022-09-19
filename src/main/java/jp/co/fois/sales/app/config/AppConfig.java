package jp.co.fois.sales.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <pre>
 * アプリケーションの設定クラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/04 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
