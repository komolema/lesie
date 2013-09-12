/**
 *      Copyright 2013 CPUT
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.vito.util;

import java.lang.reflect.Field;

import com.vito.framework.annotations.logging.InjectLogger;
import org.slf4j.Logger;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class Slf4jTypeListener implements TypeListener {

    public <I> void hear(TypeLiteral<I> aTypeLiteral, TypeEncounter<I> aTypeEncounter) {

        for (Field field : aTypeLiteral.getRawType().getDeclaredFields()) {
            if (field.getType() == Logger.class
                    && field.isAnnotationPresent(InjectLogger.class)) {
                aTypeEncounter.register(new Slf4jMembersInjector<I>(field));
            }
        }
    }
}
