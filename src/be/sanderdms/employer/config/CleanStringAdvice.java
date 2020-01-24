package be.sanderdms.employer.config;

import java.beans.PropertyEditorSupport;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import be.sanderdms.utils.MyUtils;

/* Sanitize incoming input from controllers.
 * force UTF-8 encoding */

@ControllerAdvice
public class CleanStringAdvice {
    static public class StringCleaner extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) {
            text = MyUtils.encodeUTF8String(text); // TODO: find root cause for this
            if (text == null) {
                setValue(null);
            }
            else {
                String safe = Jsoup.clean(text, Whitelist.simpleText());
                setValue(safe);
            }
        }
    }

    @InitBinder
    public void bindStringCleaner(WebDataBinder webDataBinder) {
        StringCleaner stringCleaner = new StringCleaner();
        webDataBinder.registerCustomEditor(String.class, stringCleaner);
    }

}