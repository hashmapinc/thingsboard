/**
 * Copyright © 2016-2017 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.actors.shared.rule;

import akka.actor.ActorContext;
import akka.actor.ActorRef;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.rule.RuleActorMetaData;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;
import org.thingsboard.server.common.data.rule.RuleMetaData;

public class TenantRuleManager extends RuleManager {
    
    public TenantRuleManager(ActorSystemContext systemContext, TenantId tenantId) {
        super(systemContext, tenantId);
    }

    @Override
    public void init(ActorContext context) {
        if (systemContext.isTenantComponentsInitEnabled()) {
            super.init(context);
        }
    }

    @Override
    FetchFunction<RuleMetaData> getFetchRulesFunction() {
        return link -> ruleService.findTenantRules(tenantId, link);
    }

    @Override
    String getDispatcherName() {
        return DefaultActorService.TENANT_RULE_DISPATCHER_NAME;
    }

    @Override
    RuleActorMetaData getRuleActorMetadata(RuleMetaData rule, ActorRef actorRef) {
        return RuleActorMetaData.tenantRule(rule.getId(), rule.getWeight(), actorRef);
    }
}
