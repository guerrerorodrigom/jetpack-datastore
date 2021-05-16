package com.rodrigoguerrero.spacedata.data

import kotlinx.coroutines.flow.flowOf
import java.util.*

fun SpaceMissions() = flowOf(
    listOf(
        SpaceMission(
            name = "Freedom 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1961, 4, 5) },
            crew = "Alan Shepard",
            image = "https://upload.wikimedia.org/wikipedia/commons/8/83/Mercury_3_-_Patch.png"
        ),
        SpaceMission(
            name = "Liberty Bell 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1961, 6, 5) },
            crew = "Gus Grissom",
            image = "https://upload.wikimedia.org/wikipedia/commons/4/48/Mercury_4_-_Patch.png"
        ),
        SpaceMission(
            name = "Friendship 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1962, 1, 20) },
            crew = "John Glenn",
            image = "https://upload.wikimedia.org/wikipedia/commons/6/68/Mercury_6_-_Patch.png"
        ),
        SpaceMission(
            name = "Aurora 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1962, 4, 24) },
            crew = "Scott Carpenter",
            image = "https://upload.wikimedia.org/wikipedia/commons/3/38/Aurora_7_patch.png"
        ),
        SpaceMission(
            name = "Sigma 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1962, 9, 3) },
            crew = "Walter Schirra",
            image = "https://upload.wikimedia.org/wikipedia/commons/8/87/Mercury-8-patch.png"
        ),
        SpaceMission(
            name = "Faith 7",
            program = SpaceProgram.Mercury,
            date = Calendar.getInstance().apply { set(1963, 4, 15) },
            crew = "Gordon Cooper",
            image = "https://upload.wikimedia.org/wikipedia/commons/c/c5/Mercury_9_-_Patch.png"
        ),
        SpaceMission(
            name = "Gemini 3",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1965, 2, 23) },
            crew = "Grissom & Young",
            image = "https://upload.wikimedia.org/wikipedia/commons/7/7c/Gemini3.png"
        ),
        SpaceMission(
            name = "Gemini IV",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1965, 5, 3) },
            crew = "McDivitt & White",
            image = "https://upload.wikimedia.org/wikipedia/commons/0/07/Gemini_Four_patch.jpg"
        ),
        SpaceMission(
            name = "Gemini V",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1965, 7, 21) },
            crew = "Cooper & Conrad",
            image = "https://upload.wikimedia.org/wikipedia/commons/c/ce/Gemini5insignia.png"
        ),
        SpaceMission(
            name = "Gemini VII",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1965, 11, 4) },
            crew = "Borman & Lovell",
            image = "https://upload.wikimedia.org/wikipedia/commons/d/d9/Gemini_VII_patch.png"
        ),
        SpaceMission(
            name = "Gemini VI-A",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1965, 11, 15) },
            crew = "Schirra & Stafford",
            image = "https://upload.wikimedia.org/wikipedia/commons/1/10/Gemini_6A_patch.png"
        ),
        SpaceMission(
            name = "Gemini VIII",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1966, 2, 16) },
            crew = "Armstrong & Scott",
            image = "https://upload.wikimedia.org/wikipedia/commons/6/6d/Ge08Patch_orig.png"
        ),
        SpaceMission(
            name = "Gemini IX-A",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1966, 5, 3) },
            crew = "Stafford & Cernan",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Ge09Patch_orig.png/1190px-Ge09Patch_orig.png"
        ),
        SpaceMission(
            name = "Gemini X",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1966, 6, 18) },
            crew = "Young & Collins",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Gemini_10_mission_patch_original.png/999px-Gemini_10_mission_patch_original.png"
        ),
        SpaceMission(
            name = "Gemini XI",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1966, 8, 12) },
            crew = "Conrad & Gordon",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Gemini_11_patch.png/628px-Gemini_11_patch.png"
        ),
        SpaceMission(
            name = "Gemini XII",
            program = SpaceProgram.Gemini,
            date = Calendar.getInstance().apply { set(1966, 10, 11) },
            crew = "Lowell & Aldrin",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Gemini_12_insignia.png/887px-Gemini_12_insignia.png"
        ),
        SpaceMission(
            name = "Apollo 1",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1967, 0, 27) },
            crew = "Grissom, White & Chaffee",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Apollo_1_patch.png/1024px-Apollo_1_patch.png"
        ),
        SpaceMission(
            name = "Apollo 7",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1968, 9, 11) },
            crew = "Schirra, Cunningham & Eisele",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Apollo7.png/1280px-Apollo7.png"
        ),
        SpaceMission(
            name = "Apollo 8",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1968, 11, 21) },
            crew = "Borman, Lovell & Anders",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Apollo-8-patch.png/1024px-Apollo-8-patch.png"
        ),
        SpaceMission(
            name = "Apollo 9",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1969, 2, 3) },
            crew = "McDivitt, Scott & Schweickart",
            image = "https://upload.wikimedia.org/wikipedia/commons/1/1d/Apollo_9_mission_patch.png"
        ),
        SpaceMission(
            name = "Apollo 10",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1969, 4, 18) },
            crew = "Stafford, Young & Cernan",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Apollo-10-LOGO.png/800px-Apollo-10-LOGO.png"
        ),
        SpaceMission(
            name = "Apollo 11",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1969, 6, 16) },
            crew = "Armstrong, Collins & Aldrin",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Apollo_11_insignia.png/1024px-Apollo_11_insignia.png"
        ),
        SpaceMission(
            name = "Apollo 12",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1969, 10, 14) },
            crew = "Conrad, Gordon & Bean",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Apollo_12_insignia.png/1024px-Apollo_12_insignia.png"
        ),
        SpaceMission(
            name = "Apollo 13",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1970, 3, 11) },
            crew = "Lovell, Swigert & Haise",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Apollo_13-insignia.png/1024px-Apollo_13-insignia.png"
        ),
        SpaceMission(
            name = "Apollo 14",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1971, 0, 31) },
            crew = "Shepard, Roosa & Mitchell",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Apollo_14-insignia.png/1024px-Apollo_14-insignia.png"
        ),
        SpaceMission(
            name = "Apollo 15",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1971, 6, 26) },
            crew = "Scott, Worden & Irwin",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Apollo_15-insignia.png/1024px-Apollo_15-insignia.png"
        ),
        SpaceMission(
            name = "Apollo 16",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1972, 3, 16) },
            crew = "Young, Mattingly & Duke",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Apollo-16-LOGO.png/1024px-Apollo-16-LOGO.png"
        ),
        SpaceMission(
            name = "Apollo 17",
            program = SpaceProgram.Apollo,
            date = Calendar.getInstance().apply { set(1972, 11, 7) },
            crew = "Cernan, Evans & Schmitt",
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Apollo_17-insignia.png/1024px-Apollo_17-insignia.png"
        )
    )
)
