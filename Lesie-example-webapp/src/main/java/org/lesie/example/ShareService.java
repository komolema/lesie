/**
 *      Copyright 2015 CPUT
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


package org.lesie.example;

import com.lesie.framework.annotations.ExitPoint;
import com.lesie.framework.annotations.Gate;
import com.lesie.framework.request.SharingRequest;

@Gate
public class ShareService {

    @ExitPoint
    public void shareData(SharingRequest sharingRequest, String otherStuff) {
        doSomething();
    }

    private void doSomething(){
        System.out.println("doSomething");
    }
}
