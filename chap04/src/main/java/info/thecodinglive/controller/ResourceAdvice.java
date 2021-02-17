package info.thecodinglive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice
public class ResourceAdvice {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    //내가 설정한 Resolver에 맞춰서 로드할 수 있게 해줌
    @ModelAttribute("versionResourceResolver")
    public ResourceUrlProvider versionResourceResolver() {
        return this.resourceUrlProvider;
    }
}
