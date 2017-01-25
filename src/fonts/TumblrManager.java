package fonts;

import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

/**
 *
 * @author Luke
 */
public class TumblrManager implements BotFunctions{
    public static final String TUMBLR_CHARS = "αв¢∂єfgнιנкℓмиσρqяѕтυνωχуz";
    
    public String toTumblr(String string){
        StringBuilder sb = new StringBuilder();
        char[] tumblrchars = TUMBLR_CHARS.toCharArray();
        
        char[] tmp = string.toCharArray();
        
        for(int i=0;i<tmp.length;i++){
            int index = tmp[i];
            int temp_lowercase = 96;
            int temp_uppercase = 64;
            
            if(index<=122 && index>=97){
                sb.append(tumblrchars[index-temp_lowercase-1]);
            }
            else if(index<=90 && index>=65){
                sb.append(tumblrchars[index-temp_uppercase-1]);
            }
            else if(index==32){
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }

    @Override
    public InlineQueryResultArticle getPreparedFont(String input) {
        InlineQueryResultArticle article = new InlineQueryResultArticle();
        
        article.setTitle("TumblrGirl");
        article.setId("5");
        article.setDescription(toTumblr(input));
        InputTextMessageContent messageContent = new InputTextMessageContent();
        messageContent.setMessageText(toTumblr(input));
        messageContent.disableWebPagePreview();
        messageContent.enableMarkdown(false);
        article.setInputMessageContent(messageContent);
        
        return article;
    }
}